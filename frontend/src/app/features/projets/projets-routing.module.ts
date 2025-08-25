import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjetListComponent } from './projet-list/projet-list.component';
import { ProjetDetailComponent } from './projet-detail/projet-detail.component';

const routes: Routes = [
  { path: '', component: ProjetListComponent },
  { path: ':id', component: ProjetDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjetsRoutingModule {}
