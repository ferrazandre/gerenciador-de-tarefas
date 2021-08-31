import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TarefaService } from './tarefa.service';
import { Tarefa } from './tarefa';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  tarefas: Tarefa[] = []
  form: FormGroup = new FormGroup({
    description: new FormControl('')
  })
  constructor(
    private service: TarefaService
  ){}
  ngOnInit(){
    this.listarTasks();
  }
  listarTasks(){
    this.service.listAll().subscribe(tarefaList => this.tarefas = tarefaList)
  }
  submit(){
    const tarefa: Tarefa  = {...this.form.value}
    this.service
                .salvar(tarefa)
                .subscribe(savedTarefa => {
                  this.tarefas.push(savedTarefa)
                  this.form.reset()
                })
  }
  delete(id: number){
    this.service.deletar(id).subscribe({
      next:(response)=> this.listarTasks()
    })
  }
  done(tarefa: Tarefa){
    this.service.done(tarefa.id).subscribe({
      next:(tarefaAtualizada) => {
        tarefa.done = tarefaAtualizada.done
        tarefa.doneDate = tarefaAtualizada.doneDate
      }
    })
  }
}
