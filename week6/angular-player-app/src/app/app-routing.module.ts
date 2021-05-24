import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPlayerComponent } from './add-player/add-player.component';
import { DeletePlayerComponent } from './delete-player/delete-player.component';
import { PlayersListComponent } from './players-list/players-list.component';
import { SearchPlayerComponent } from './search-player/search-player.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';

const routes: Routes = [
    {path: 'addPlayer', component: AddPlayerComponent},
    {path: 'deletePlayer', component: DeletePlayerComponent},
    {path: 'updatePlayer', component: UpdatePlayerComponent},
    {path: 'searchPlayer', component: SearchPlayerComponent},
    {path: 'playersList', component: PlayersListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
