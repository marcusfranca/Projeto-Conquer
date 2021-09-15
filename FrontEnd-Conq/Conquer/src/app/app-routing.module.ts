
import { UpdateComponent } from './conquer/update/update.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/user/list/list.component';
import { CreateComponent } from './conquer/create/create.component';
import { LoginComponent } from './conquer/login/login.component';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  { path: "list", component: ListComponent },
  { path: "create", component: CreateComponent },
  { path: "update/:id", component: UpdateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
