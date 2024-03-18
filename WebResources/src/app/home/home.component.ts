import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import * as moment from 'moment';
import { Subscription } from 'rxjs';
import { FilmService } from '../film.service';
import { Film } from '../model/Film';
import { FilmResponse } from '../response/FilmResponse';
import { UtilService } from '../util.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  formGroup: FormGroup;
  responseList?: Film[];
  genres?: string[];
  programmazionList?: Film[] = [];
  programmazionListFull?: Film[] = [];
  isChecked: boolean = false;

  subscriptions: Subscription[] = [];

  constructor(private filmService: FilmService, formBuilder: FormBuilder, utilService: UtilService) {

    this.formGroup = formBuilder.group({
      weekProgrammazione: [''],
      dataFineProgrammazione: [''],
      titolo: [''],
      genres: ['']
    });

    this.subscriptions.push(this.formGroup.controls['genres'].valueChanges.subscribe((gen: string) => {

      if (gen == 'Choose...') {
        this.programmazionList = this.programmazionListFull;
      } else {
        this.programmazionList = this.programmazionListFull?.filter(film => !!film.genres?.find(g => g == gen));
      }


    }));


    this.subscriptions.push(this.formGroup.controls['weekProgrammazione'].valueChanges
      .subscribe((weekInizioProgrammazione: string) => {

        if (!weekInizioProgrammazione) {
          return;
        }

        const week = utilService.getWeekFromWeekInput(weekInizioProgrammazione);

        if (week == -1) {
          return;
        }

        this.programmazionList = this.programmazionListFull?.filter((film: Film) => {

          if (film.dataInizioProgrammazione) {

            const dataInizioProgFilm = new Date(film.dataInizioProgrammazione || '2999-12-31');
            const dataFineProgFilm = new Date(film.dataFineProgrammazione || '1970-01-01');

            return week >= moment(dataInizioProgFilm).week() && week <= moment(dataFineProgFilm).week();

          }

          return false;

        });

      }));

  }

  ngOnInit(): void {


    this.filmService.getAllFilms().subscribe({

      next: (response: FilmResponse) => {

        this.genres = response.genres;
        this.responseList = response.movies as Film[];

        const today = new Date();
        today.setHours(0, 0, 0, 0);

        this.programmazionListFull = this.responseList.filter(f => {

          if (f.dataFineProgrammazione) {
            const dataFine = new Date(f.dataFineProgrammazione || '1970-01-01');
            return dataFine >= today;
          }

          return false;

        });

        this.programmazionList = this.programmazionListFull;

      },

      error: (error) => {

        alert(error.message);
      }


    });

  }


  ngOnDestroy() {
    for (const s of this.subscriptions) {
      s.unsubscribe();
    }
  }

}