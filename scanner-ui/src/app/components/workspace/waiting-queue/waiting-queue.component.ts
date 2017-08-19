import { Component, OnInit } from '@angular/core';
import {ScanTaskStatusEnum} from "../../../enums/scantaskstatus.enum";
import {ScanTaskService} from "../../../services/scantask.service";
import {ScanTask} from "../../../models/scantask.model";

@Component({
  selector: 'app-waiting-queue',
  templateUrl: './waiting-queue.component.html',
  styleUrls: ['./waiting-queue.component.css']
})
export class WaitingQueueComponent implements OnInit {

  scanTasks: ScanTask[];

  constructor(private scanTaskService: ScanTaskService) {
  }

  ngOnInit() {
    //this.scanTaskService.getScanTasks().subscribe(r => this.scanTasks = r);
    this.scanTaskService.getScanTaskByStatus(ScanTaskStatusEnum.SCANNED).subscribe(r => this.scanTasks = r);
  }

}
