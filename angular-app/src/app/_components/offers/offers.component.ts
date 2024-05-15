import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Category } from 'src/app/_model/Category';
import { Offer } from 'src/app/_model/Offer';
import { CategoryService } from 'src/app/_services/category/category.service';
import { OfferService } from 'src/app/_services/offer/offer.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private offersService: OfferService,
    private categoryService: CategoryService, private formBuilder: FormBuilder, private router: Router,
    private changeDetectorRef: ChangeDetectorRef) { }

  public isUserLoggedIn: boolean = false;
  public pageSize = 8;
  public currentPage = 0;
  public total = 0;
  public categories:Category[]=[];
  public array: Offer[]=[];
  public dataSource: any;
  public selectedElementValues: { categoryTitle: string, categoryId: number }[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
	obs: Observable<any> | undefined;

  ngOnInit(): void {
    this.isUserLoggedIn=this.authenticationService.isLoggedIn&&this.authenticationService.isActivated;
    this.selectElement();
    this.getAll();
  }

  isLoggedIn(){
    return this.authenticationService.isActivated && this.authenticationService.isLoggedIn;
  }

  public details(o: Offer){
    this.offersService.setOffer(o);
    this.router.navigate(['/offer-details']);
  }

  public getName(category: Category) :string{
    return this.categoryService.getCategoryTitle(category);
  }

  public selectElement(){
    this.categoryService.findAll().subscribe(
      (response)=>{
        this.categories=response;
        for(var cat of response){
          let categoryId = cat.id;
          let categoryTitle = this.getName(cat);
          this.selectedElementValues.push({categoryTitle, categoryId});
        }
        this.selectedElementValues.sort((a,b)=>a.categoryTitle.localeCompare(b.categoryTitle));
      }
    );
  }

  public getAll(){
    this.offersService.findAll().subscribe(
      (response)=>{
        this.changeDetectorRef.detectChanges();
        this.dataSource=new MatTableDataSource<Offer>(response);
        this.dataSource.paginator=this.paginator;
        this.obs=this.dataSource.connect();
        this.array=response;
        this.total=this.array.length;
        this.iterator();
      }
    )
  }

  iterator(){
    const ending = (this.currentPage+1)*this.pageSize;
    const begining = this.currentPage*this.pageSize;
    const part = this.array.slice(begining, ending);
    this.dataSource=part;
  }

  public handlePage(p: any){
    this.currentPage=p.pageIndex;
    this.pageSize=p.pageSize;
    this.iterator();
  }

  public selectCategory(id: number){
    this.offersService.findByIdCategory(id).subscribe(
      (response)=>{
        this.changeDetectorRef.detectChanges();
        this.dataSource=new MatTableDataSource<Offer>(response);
        this.dataSource.paginator=this.paginator;
        this.obs=this.dataSource.connect();
        this.array=response;
        this.total=this.array.length;
        this.iterator();
      }
    )
  }

}
