export interface UserData {
  displayName: string | null;
  email: string | null;
  phoneNumber: string | null;
  photoUrl: string | null;
  providerId: string;
  /**
   * The user's unique ID.
   */
  uid: string;
}
