import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { delay } from 'rxjs';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Attribute } from 'src/app/_model/Attribute';
import { Category } from 'src/app/_model/Category';
import { ImageRequest } from 'src/app/_model/ImageRequest';
import { Offer } from 'src/app/_model/Offer';
import { Product } from 'src/app/_model/Product';
import { User } from 'src/app/_model/User';
import { Value } from 'src/app/_model/Value';
import { CategoryService } from 'src/app/_services/category/category.service';
import { ImageService } from 'src/app/_services/image/image.service';
import { OfferService } from 'src/app/_services/offer/offer.service';
import { ProductService } from 'src/app/_services/product/product.service';

@Component({
  selector: 'app-new-offer',
  templateUrl: './new-offer.component.html',
  styleUrls: ['./new-offer.component.css']
})
export class NewOfferComponent implements OnInit {

  public user: User | null = null;
  public form: FormGroup = new FormGroup({});
  public attributesForm: FormGroup = new FormGroup({});
  public categories: Category[] = [];
  public attributes: Attribute[] = [];
  public isProductNew: boolean = false;
  public selectCategory: { categoryId: number, categoryName: string }[] = [];
  public selectNewOrUsed: Array<String> = [];

  public categoryId: number = 0;
  public selectedCategory: Category | undefined;

  constructor(private authenticationService: AuthenticationService, private snackBar: MatSnackBar,
    private formBuilder: FormBuilder, private router: Router,
    private imageService: ImageService, private productService: ProductService,
    private categoryService: CategoryService, private offerService: OfferService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: [null, Validators.required],
      price: [null, Validators.required],
      description: [null, Validators.required],
      contact: [null, Validators.required],
      address: [null, Validators.required],
      categorySelect: new FormControl(),
      newOrUsed: new FormControl(),
      attributes: this.attributesForm,
      img1: [null],
      img2: [null],
      img3: [null],
      img4: [null],
    });

    this.user = this.authenticationService.loggedUser;

    this.categoryService.findAll().subscribe(
      (response) => {
        this.categories = response;
        for (var cat of response) {
          let categoryId = cat.id;
          let categoryName = this.getCategoryName(cat);
          this.selectCategory.push({ categoryId, categoryName });
        }
        this.selectCategory.sort((a, b) => a.categoryName.localeCompare(b.categoryName));
      }
    )

  }

  public getCategoryName(category: Category): string {
    return this.categoryService.getCategoryTitle(category);
  }

  selectNewOrUsedHandler(event: any) {
    this.isProductNew = event.target.value === "1";
  }

  selectCategoryHandler(event: any) {
    this.categoryId = event.target.value;
    this.selectedCategory = this.categories.find(c => c.id == this.categoryId);
    if (this.selectedCategory) {
      this.categoryService.findAttributesOfCategory(this.selectedCategory.id).subscribe(
        response => {
          this.attributes = response;
          this.attributesForm = new FormGroup({});
          this.attributes.forEach(a => this.attributesForm.addControl(a.name, new FormControl('')));
        }
      );
    }
  }

  public createNewOffer() {
    let name = this.form.value.name;
    let price = this.form.value.price;
    let description = this.form.value.description;
    let contact = this.form.value.contact;
    let address = this.form.value.address;
    let category = this.selectedCategory;
    let isProductNew = this.isProductNew;
    let img1 = this.form.value.img1;
    let img2 = this.form.value.img2;
    let img3 = this.form.value.img3;
    let img4 = this.form.value.img4;

    
    if (category && this.user?.id) {
      let userId = this.user?.id;
      let product = new Product(null, address, contact, isProductNew, description, name, price, category, []);

      this.productService.insert(product).subscribe({
        next: (response: Product)=>{
          if(img1) this.imageService.insert(new ImageRequest(null, img1, response)).subscribe();
          if(img2) this.imageService.insert(new ImageRequest(null, img2, response)).pipe(delay(200)).subscribe();
          if(img3) this.imageService.insert(new ImageRequest(null, img3, response)).pipe(delay(200)).subscribe();
          if(img4) this.imageService.insert(new ImageRequest(null, img4, response)).pipe(delay(200)).subscribe();

          if(response.id){
            this.productService.findById(response.id).pipe(delay(200)).subscribe({
              next: (response: Product)=>{
                this.offerService.insert(new Offer(null, userId, response, true)).subscribe({
                  next:(response:Offer)=>{
                    for(let att of this.attributes){
                      let attValue = this.attributesForm.get(att.name)?.value;

                      if(attValue && response.product.id){
                        this.productService.insertValue(new Value(response.product.id, att.id, response.product.category.id, attValue)).pipe(delay(200)).subscribe();
                      }
                    }

                    this.snackBar.open("Uspjesno ste kreirali novu ponudu!", '', {
                      horizontalPosition: "center",
                      duration: 3000,
                    });
                    this.router.navigate(['/']);
                  },
                  error:()=>{
                    this.snackBar.open("Neuspjesno dodavanje ponude!", '', {
                      horizontalPosition: "center",
                      duration: 3000,
                    });
                  }
                })
              },
              error:()=>{
                this.snackBar.open("Neuspjesno dodavanje ponude!", '', {
                  horizontalPosition: "center",
                  duration: 3000,
                });
              }
            })
          }
        },
        error:()=>{
          this.snackBar.open("Neuspjesno dodavanje ponude!", '', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
      })

    }
  }

}
