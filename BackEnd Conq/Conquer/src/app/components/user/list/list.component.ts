import { Create } from './../../../conquer/create/create.model';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { List } from 'src/app/list.model';
import { RestapiService } from 'src/app/restapi.service';
import { ListDataSource } from './list-datasource';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<List>;
  dataSource: ListDataSource;

  List: any;

  create: Create = {
    name: '',
    email: '',
    phone: '',
    birthday: ''
  }

  displayedColumns = ['id', 'name', 'email', 'phone', 'birthay', 'action']; //colunas

  constructor(private service: RestapiService, private router: Router, 
    private route: ActivatedRoute) {
    this.dataSource = new ListDataSource();
  }
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id') || ' '
    this.service.readById(id).subscribe(Create => {
      this.create = Create
    })
    let resp = this.service.Users();
    resp.subscribe(data => this.List = data);
  }

  delete(id: number) {
    if (confirm("Deseja deletar a Lista: " + id)) { 
      this.service.Delete(id).subscribe(
        () => {
          this.ngOnInit(); 
        },
        error => {
          alert("Erro ao deletar " + JSON.stringify(error))
        }
      )
    }


  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }

}
