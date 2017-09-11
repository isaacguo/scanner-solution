import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ScanTaskStatusEnum} from "../../../enums/scantaskstatus.enum";
import {ScanTaskService} from "../../../services/scantask.service";
import {ScanTask} from "../../../models/scantask.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {ImageService} from "../../../services/image.service";
import { GeneralSetting } from "../../../models/general_setting.model";
import { GeneralSettingService } from "../../../services/general_setting.service";

@Component({
  selector: 'app-waiting-queue',
  templateUrl: './waiting-queue.component.html',
  styleUrls: ['./waiting-queue.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class WaitingQueueComponent implements OnInit {

  scanTasks: ScanTask[];
  selectedScanTask: ScanTask;
  selectedScanPairIndex: number = 0;
  imagePath: string;
  generalSetting:GeneralSetting={};

  constructor(private scanTaskService: ScanTaskService, imageService: ImageService,private generalSettingService:GeneralSettingService) {
  }

  ngOnInit() {
    //this.scanTaskService.getScanTasks().subscribe(r => this.scanTasks = r);
    this.scanTaskService.getScanTaskByStatus(ScanTaskStatusEnum.SCANNED).subscribe(r => this.scanTasks = r);
    this.generalSettingService.getSettings().subscribe(r=>{
      this.generalSetting=r;
    });

  }

  onShowManualCheckDialogModal() {
  }

  onScanTaskClicked(showManualCheckDialogModal: ModalComponent, scanTask: ScanTask) {
    this.selectedScanTask = scanTask;
    var uuid = this.selectedScanTask.uuid;
    var firstImage = this.selectedScanTask.scanPairList[0].imageName;
    this.imagePath = `/scannerprocessor/images/${uuid}/${firstImage}/`;
    showManualCheckDialogModal.open("lg");
  }

  onShowPrevClicked() {
    console.log(this.selectedScanPairIndex);
    if (this.selectedScanPairIndex > 0)
      this.selectedScanPairIndex=this.selectedScanPairIndex-1;
    console.log(this.selectedScanPairIndex);
    this.imagePath = `/scannerprocessor/images/${this.selectedScanTask.uuid}/${this.selectedScanTask.scanPairList[this.selectedScanPairIndex].imageName}/`;
  }

  onShowNextClicked() {
    console.log(this.selectedScanPairIndex);
    if (this.selectedScanPairIndex < this.selectedScanTask.scanPairList.length - 1)
      this.selectedScanPairIndex=this.selectedScanPairIndex+1;
    console.log(this.selectedScanPairIndex);
    this.imagePath = `/scannerprocessor/images/${this.selectedScanTask.uuid}/${this.selectedScanTask.scanPairList[this.selectedScanPairIndex].imageName}/`;
  }
}
