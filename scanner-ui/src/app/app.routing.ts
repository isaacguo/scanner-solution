import {RouterModule, Routes} from "@angular/router";
import {OverviewComponent} from "./components/overview/overview.component";
import {ModuleWithProviders} from "@angular/core";
import {WorkspaceComponent} from "./components/workspace/workspace.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {NotFoundComponent} from "./components/notfound/notfound.component";
import {WaitingQueueComponent} from "./components/workspace/waiting-queue/waiting-queue.component";
import {ScanningQueueComponent} from "./components/workspace/scanning-queue/scanning-queue.component";
import { GeneralComponent } from "./components/settings/general/general.component";

const appRoutes: Routes = [
  {
    path: '',
    component: OverviewComponent
  },
  {
    path: 'workspace',
    component: WorkspaceComponent,
    children:
      [
        {
          path:'',
          component:ScanningQueueComponent,
        },
        {
          path:'scanning-queue',
          component:ScanningQueueComponent,
        },
        {
          path:'waiting-queue',
          component:WaitingQueueComponent,
        }
      ]
  },
  {
    path: 'settings',
    component: SettingsComponent,
    children:[
      {path:'general',component:GeneralComponent}
    ]
  },
  {
    path:'**',
    component:NotFoundComponent
  }

]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
