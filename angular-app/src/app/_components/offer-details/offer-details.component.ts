import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { AttributeValue } from 'src/app/_model/AttributeValue';
import { Comment } from 'src/app/_model/Comment';
import { Offer } from 'src/app/_model/Offer';
import { User } from 'src/app/_model/User';
import { CommentService } from 'src/app/_services/comment/comment.service';
import { OfferService } from 'src/app/_services/offer/offer.service';
import { ProductService } from 'src/app/_services/product/product.service';

@Component({
  selector: 'app-offer-details',
  templateUrl: './offer-details.component.html',
  styleUrls: ['./offer-details.component.css']
})
export class OfferDetailsComponent implements OnInit {

  public offer!: Offer;
  public attributes: AttributeValue[] = [];
  public user: User | null = null;
  public comments: Comment[] = [];

  public form: FormGroup = new FormGroup({});

  public constructor(private authenticationService: AuthenticationService, private router: Router,
    private formBuilder: FormBuilder, private snackBar: MatSnackBar,
    private offerService: OfferService, private productService: ProductService,
    private commentService: CommentService) { }


  private findAllComments(id: number) {
    this.commentService.findCommentsByIdOffer(id).subscribe((response) => {
      this.comments = response;
    })

  }

  public isUserOwner(){
    return (this.user && this.user?.id===this.offer.idUser);
  }

  public isProductNew() {
    return this.offer.product.isNew;
  }

  private getAttributeValues(id: number) {
    this.productService.findAttributeValues(id).subscribe(result => this.attributes = result);
  }

  public isLoggedIn() {
    return this.authenticationService.isActivated && this.authenticationService.isLoggedIn;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      newComment: [null, Validators.required]
    });

    this.user = this.authenticationService.loggedUser;

    this.offerService.offer.subscribe((value: Offer) => {
      this.offer = value;
      if (value.id)
        this.findAllComments(value.id);
      if (value.product.id) this.getAttributeValues(value.product.id);

    })
  }

  public createComment() {
    let newComment = this.form.value.newComment;
    if (this.authenticationService.loggedUser && this.offer) {
      let comment = new Comment(null, newComment, this.authenticationService.loggedUser, this.offer);
      this.commentService.insert(comment).subscribe({
        next: (response: Comment) => {
          this.snackBar.open("Uspjesno se kreirali novi komentar!", '', {
            horizontalPosition: "center",
            duration: 3000,
          });
          if (response.offer.id) this.findAllComments(response.offer.id);
          this.form.reset();
        },
        error: () => {
          this.snackBar.open("Niste uspjesno kreirali komentar!", '', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
      })
    }

  }

  public purchaseOffer(offer: Offer) {
    this.offerService.setOffer(offer);
    this.router.navigate(['/purchase-offer']);
  }



}
