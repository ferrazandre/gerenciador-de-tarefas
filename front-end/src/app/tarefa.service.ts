import { Injectable } from '@angular/core';
import { Tarefa } from './tarefa';
import { Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {
  apiURL: string = 'http://localhost:8080/tarefa';

  constructor(
    private htpp: HttpClient
    ){}

  salvar(tarefa: Tarefa) : Observable<Tarefa>{
      return this.htpp.post<Tarefa>(this.apiURL,tarefa)
  }
  listAll() : Observable<Tarefa[]>{
    return this.htpp.get<Tarefa[]>(this.apiURL);
  }
}
