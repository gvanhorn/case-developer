import {Component, inject, Input, OnInit} from '@angular/core';
import {Participant} from "../../../api/models/participant";
import {ApiService} from "../../../api/services/api.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-participant-row',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './participant-row.component.html',
  styleUrl: './participant-row.component.css'
})
export class ParticipantRowComponent implements OnInit{
  apiService = inject(ApiService);

  @Input() participant!: Participant;

  pensionAge: number = 0;
  expectedValue: number = 0;

  ngOnInit() {
    this.pensionAge = this.calculateAge(new Date(this.participant?.date_of_birth));
    this.handleUpdatePensionAge();
  }

  calculateAge(birthDate: Date): number {
    const diff = Date.now() - birthDate.getTime();
    const ageDate = new Date(diff);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  }

  handleUpdatePensionAge() {
    this.apiService.calculateExpectedValue({id: this.participant.id, pensionAge: this.pensionAge})
      .subscribe((expectedValue) => {
        this.expectedValue = expectedValue
      })
  }
}
