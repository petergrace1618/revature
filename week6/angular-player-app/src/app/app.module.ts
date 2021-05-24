import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DeletePlayerComponent } from './delete-player/delete-player.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';
import { AddPlayerComponent } from './add-player/add-player.component';
import { PlayersListComponent } from './players-list/players-list.component';
import { SearchPlayerComponent } from './search-player/search-player.component';

@NgModule({
  declarations: [
    AppComponent,
    DeletePlayerComponent,
    UpdatePlayerComponent,
    AddPlayerComponent,
    PlayersListComponent,
    SearchPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
