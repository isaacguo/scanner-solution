import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms'

import {AppComponent} from './app.component';
import {OverviewComponent} from './components/overview/overview.component';
import {routing} from './app.routing';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {WorkspaceComponent} from './components/workspace/workspace.component';
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {FileUploadModule} from "ng2-file-upload";
import {NotFoundComponent} from './components/notfound/notfound.component';
import {SettingsComponent} from './components/settings/settings.component';
import {WaitingQueueComponent} from './components/workspace/waiting-queue/waiting-queue.component';
import { ScanningQueueComponent } from './components/workspace/scanning-queue/scanning-queue.component';
import {UploadService} from "./services/upload.service";
import {HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent,
    OverviewComponent,
    WorkspaceComponent,
    NotFoundComponent,
    SettingsComponent,
    WaitingQueueComponent,
    ScanningQueueComponent,
  ],
  imports: [
    BrowserModule, FormsModule, routing, Ng2Bs3ModalModule, FileUploadModule, HttpModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    UploadService

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
