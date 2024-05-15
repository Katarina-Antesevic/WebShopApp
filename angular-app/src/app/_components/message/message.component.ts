import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Message } from 'src/app/_model/Message';
import { MessageService } from 'src/app/_services/message/message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  public form: FormGroup = new FormGroup({});

  public idSender: number | null = null;

  constructor(private messageService: MessageService, private snackBar: MatSnackBar, private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder, private router: Router, private datePipe: DatePipe) { }

  ngOnInit(): void {
    if (this.authenticationService.loggedUser) {
      this.idSender = this.authenticationService.loggedUser.id;
    }
    this.form = this.formBuilder.group({
      content: [null, Validators.required]
    });
  }

  sendMessage() {
    let content = this.form.value.content;
    if (content == null) {
      this.snackBar.open("Niste unijeli tekst poruke!", '', {
        horizontalPosition: "center",
        duration: 3000,
      });
    }

    else {
      let currentDateTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss');
      let message = new Message(content, this.idSender, currentDateTime);
      this.messageService.insert(message).subscribe({
        next: () => {
          this.snackBar.open("Poruka je uspjesno poslana korisnickoj podrsci!", '', {
            horizontalPosition: "center",
            duration: 3000,
          });
          this.router.navigate(['/']);
        },
        error: () => {
          this.snackBar.open("Neuspjesno slanje poruke!", '', {
            horizontalPosition: "center",
            duration: 3000

          });
        }
      })
    }
  }

}
