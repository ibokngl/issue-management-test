import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class IssueService {

  private ISSUE_TYPE = "/issue";

  constructor(private apiService: ApiService){
  }

  getAll():Observable<any>{
    return this.apiService.get(this.ISSUE_TYPE).pipe(map(
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
    return this.apiService.get(this.ISSUE_TYPE,id).pipe(map(
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

  createIssue(project):Observable<any>{
    return this.apiService.post(this.ISSUE_TYPE,project).pipe(map(
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
    return this.apiService.delete(this.ISSUE_TYPE,id).pipe(map(
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
