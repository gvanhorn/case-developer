import {Component, OnInit, inject } from '@angular/core';
import {ApiModule} from "../../../api/api.module";
import {Participant} from "../../../api/models/participant";
import {ApiService} from "../../../api/services";
import {HttpClientModule} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {ApiConfiguration} from "../../../api/api-configuration";
import {ParticipantRowComponent} from "../participant-row/participant-row.component";

@Component({
  selector: 'app-participants-page',
  standalone: true,
  imports: [HttpClientModule, ApiModule, ParticipantRowComponent],
  templateUrl: './participants-page.component.html',
  styleUrl: './participants-page.component.css'
})
export class ParticipantsPageComponent implements OnInit {
  participants: Participant[] = [];
  apiConfig = inject(ApiConfiguration);
  apiService = inject(ApiService);

  ngOnInit() {
    this.apiConfig.rootUrl = environment.apiUrl;
    this.apiService.getParticipants()
      .subscribe((participants) => {
        this.participants = participants;
      });
  }
}
