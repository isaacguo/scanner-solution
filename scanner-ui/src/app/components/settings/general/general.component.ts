import { Component, OnInit } from '@angular/core';
import { GeneralSettingService } from "../../../services/general_setting.service";
import { GeneralSetting } from "../../../models/general_setting.model";

@Component({
  selector: 'app-general',
  templateUrl: './general.component.html',
  styleUrls: ['./general.component.css']
})
export class GeneralComponent implements OnInit {

  generalSetting:GeneralSetting={};

  constructor(private generalSettingService:GeneralSettingService) { }

  ngOnInit() {
    this.generalSettingService.getSettings().subscribe(r=>{
      this.generalSetting=r;
    });


  }

}
