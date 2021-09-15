import { RestapiService } from 'src/app/restapi.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  formulario!: FormGroup; 
  constructor(private router: Router, private service: RestapiService,
    private formBuilder: FormBuilder) { } 

  ngOnInit(): void {
    this.configurarFormulario(); 
  }

  configurarFormulario() {
    this.formulario = this.formBuilder.group({
      name: [null, Validators.required], 
      email: [null, [Validators.required, Validators.email]],
      phone: [null, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      birthday: [null, Validators.required]
    })
  }

  createList(): void {
    this.service.Create(this.formulario.value).subscribe(() => {
      this.router.navigate(['/list'])
    })

  }
  cancel(): void {
    this.router.navigate(['/list'])
  }

}
