import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  email!: string;
  password!: string;
  confirmPassword!: string;

  private reg_url = "http://localhost:8888/api/user/register";

  constructor(private router: Router,public http: HttpClient) {}

  register() {
    if (this.password !== this.confirmPassword) {
      alert('Password and Confirm Password do not match.');
      return;
    }

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
    };
    this.http.post(this.reg_url,
      "email="+this.email+"&password="+this.password
      , httpOptions).subscribe((response: any) => {
        window.alert(response.msg);
        if(response.code === 1){
          this.router.navigate(['/login']);
        }
      });
  }

  ngOnInit() {}
}
