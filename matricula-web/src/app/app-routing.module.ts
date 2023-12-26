import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MatriculaListComponent } from './components/matricula-list/matricula-list.component';
import { MatriculaCreateComponent } from './components/matricula-create/matricula-create.component';

const routes: Routes = [
  { path: '', redirectTo: 'matriculas', pathMatch: 'full' },
  { path: 'matriculas', component: MatriculaListComponent },
  { path: 'registrar-matricula', component: MatriculaCreateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
