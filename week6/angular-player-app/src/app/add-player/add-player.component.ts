import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  private player: Player;

  constructor(private service:PlayerService, private router: Router) { 
    this.player = new Player();
  }

  ngOnInit(): void {
  }

  addPlayer():void {
    this.service.addPlayer(this.player).subscribe(res=>{
      this.player = new Player();
      this.router.navigate('/playerList');
    })
  }
}
