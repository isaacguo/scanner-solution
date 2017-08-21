import {OnInit, Component, ViewEncapsulation} from "@angular/core";
import {FileUploader} from "ng2-file-upload/ng2-file-upload";
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {UploadService} from "../../services/upload.service";

/**
 * Created by yueguo01 on 7/19/2017.
 */

@Component({
  selector: 'workspace',
  templateUrl: './workspace.component.html',
  styleUrls: ['./workspace.component.css'],

})
export class WorkspaceComponent implements OnInit {

  public hasBaseDropZoneOver: boolean = false;
  public uploader: FileUploader = new FileUploader({url: '/scannerprocessor/upload/'});

  scanid: string;

  info: string;

  constructor(private uploadService: UploadService) {
    this.uploader.options.headers
  }

  ngOnInit(): void {
  }

  public fileOverBase(e: any): void {
    this.hasBaseDropZoneOver = e;
  }

  onCreateNewTaskButtonClicked(createNewTaskModal: ModalComponent) {
    this.scanid = null;
    console.log(this.scanid);
    console.log(this.scanid == null);
    console.log(this.checkScanIdIsEmpty());
    this.uploader.clearQueue();
    createNewTaskModal.open();
  }

  onCreateNewTaskModalClosed() {

  }

  onBtnClicked() {
    this.uploadService.getInfo().subscribe(r => {
      this.info = r;
    });

  }

  onBtnUploadAllClicked() {
    this.uploadService.initiateUploading().subscribe(r => {
      this.scanid = r.scanid;
      console.log("scanid:" + r.scanid);
      this.uploader.options.additionalParameter = {'scanid': r.scanid};

      this.uploader.onCompleteAll = () => {
        this.uploadService.finishUploading(r.scanid).subscribe(re => {
          console.log(re);
        });
      };
      this.uploader.uploadAll();
    });
  }

  checkScanIdIsEmpty(): boolean {
    return (this.scanid == null) || (this.scanid === "" );
  }

}
