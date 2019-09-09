import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class ProjectService {

  private PROJECT_TYPE = "/project";

  constructor(private apiService: ApiService){
  }

  getAll(page):Observable<any>{
    return this.apiService.get(this.PROJECT_TYPE+'/pagination',page).pipe(map(
      res=>{
        if (res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  getByid(id):Observable<any>{
    return this.apiService.get(this.PROJECT_TYPE+'/pagination',id).pipe(map(
      res=>{
        if (res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  createProject(project):Observable<any>{
    return this.apiService.post(this.PROJECT_TYPE,project).pipe(map(
      res=>{
        if (res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  delete(id):Observable<any>{
    return this.apiService.delete(this.PROJECT_TYPE,id).pipe(map(
      res=>{
        if (res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }
}
