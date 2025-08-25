import { Component, Input } from '@angular/core';
import { Notification } from '../../../core/models/notification.model';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-notification',
  imports:[CommonModule, ReactiveFormsModule],
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss'],
})
export class NotificationComponent {
  @Input() notifications: Notification[] = [];
}
