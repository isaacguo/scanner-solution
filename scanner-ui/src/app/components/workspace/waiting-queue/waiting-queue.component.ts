import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ScanTaskStatusEnum} from "../../../enums/scantaskstatus.enum";
import {ScanTaskService} from "../../../services/scantask.service";
import {ScanTask} from "../../../models/scantask.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {ImageService} from "../../../services/image.service";

@Component({
  selector: 'app-waiting-queue',
  templateUrl: './waiting-queue.component.html',
  styleUrls: ['./waiting-queue.component.css'],

})
export class WaitingQueueComponent implements OnInit {

  scanTasks: ScanTask[];
  selectedScanTask: ScanTask;
  imagePath: string;

  constructor(private scanTaskService: ScanTaskService, imageService: ImageService) {
  }

  ngOnInit() {
    //this.scanTaskService.getScanTasks().subscribe(r => this.scanTasks = r);
    this.scanTaskService.getScanTaskByStatus(ScanTaskStatusEnum.SCANNED).subscribe(r => this.scanTasks = r);
  }

  onShowManualCheckDialogModal() {
  }

  onScanTaskClicked(showManualCheckDialogModal: ModalComponent, uuid: String) {
    this.imagePath="http://localhost:6303/images/eb42e0af-b332-45dd-a1d8-6100e7f069c0/a.jpg/";
    showManualCheckDialogModal.open("lg");
  }

}
