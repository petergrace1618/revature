import { HttpClient } from '@angular/common/http';
import { Injectable, ɵPlayer } from '@angular/core';
import { Observable } from 'rxjs';
import { Player } from './player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private urlCrud: string;
  private urlSearch: string;

  constructor(private http: HttpClient) {
    this.urlCrud = 'http://localhost:7000/player';
    this.urlSearch = 'http://localhost:7000/players';
   }

   public addPlayer(player: Player): Observable<Player> {
     return this.http.post<Player>(this.urlCrud, player);
   }

   public getAllPlayers(): Observable<Player[]> {
     return this.http.get<Player[]>(this.urlSearch);
   }
}

