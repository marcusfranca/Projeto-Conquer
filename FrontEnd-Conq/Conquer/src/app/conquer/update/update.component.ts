import { Create } from './../create/create.model';
import { ActivatedRoute, Router } from '@angular/router';
import { RestapiService } from 'src/app/restapi.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  create: Create = {
    name: '',
    email: '',
    phone: '',
    birthday: ''
  }

  constructor(
    private service: RestapiService,
    private router: Router,
    private route: ActivatedRoute) { }


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id') || ' '
    this.service.readById(id).subscribe(Create => {
      this.create = Create
    })
  }

  updateList(): void {
    this.service.Update(this.create).subscribe(() => {
      this.router.navigate(['/list']);
    })

  }
  cancel(): void {
    this.router.navigate(['/list']);
  }

}
