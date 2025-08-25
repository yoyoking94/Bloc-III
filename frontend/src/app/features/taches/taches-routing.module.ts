import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TacheListComponent } from './tache-list/tache-list.component';
import { TacheFormComponent } from './tache-form/tache-form.component';

const routes: Routes = [
  { path: '', component: TacheListComponent },
  { path: 'nouvelle', component: TacheFormComponent },
  { path: ':id/edit', component: TacheFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TachesRoutingModule {}
