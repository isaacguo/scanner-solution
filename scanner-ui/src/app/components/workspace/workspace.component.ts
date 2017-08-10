import {OnInit, Component, Directive} from "@angular/core";
import {FileDropDirective, FileUploader} from "ng2-file-upload/ng2-file-upload";
import {ModalComponent} from "ng2-bs3-modal/components/modal";
/**
 * Created by yueguo01 on 7/19/2017.
 */

@Component({
  selector: 'workspace',
  templateUrl: './workspace.component.html',
})
export class WorkspaceComponent implements OnInit {

  public hasBaseDropZoneOver: boolean = false;
  public uploader: FileUploader = new FileUploader({url: '/app'});

  ngOnInit(): void {
  }

  public fileOverBase(e: any): void {
    this.hasBaseDropZoneOver = e;
  }

  onCreateNewTaskButtonClicked(createNewTaskModal: ModalComponent) {
    createNewTaskModal.open();
  }

  onCreateNewTaskModalClosed() {
    console.log("onCreateNewTaskModalClosed clicked");
  }
}
