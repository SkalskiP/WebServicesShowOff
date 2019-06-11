import axios from 'axios';
import * as firebase from 'firebase';
import {store} from '../index';
import {updateUserData} from '../store/account/actionCreators';
import {updateAdminStatus, updateLastLoginFailureMessage, updateLoadingStatus} from '../store/general/actionCreators';
import {UserData} from './types/UserData';

const config = {
  apiKey: 'AIzaSyBUk6dgMPAs7zM46FGg3ICj_0lU1sfjc88',
  authDomain: 'webservicesshowoff.firebaseapp.com',
  databaseURL: 'https://webservicesshowoff.firebaseio.com',
  projectId: 'webservicesshowoff',
  storageBucket: 'webservicesshowoff.appspot.com',
  messagingSenderId: '977543366915',
  appId: '1:977543366915:web:3d964a1c474d145c',
};

let stickHeader = null;

export class Firebase {
  public static auth;

  public static async setup() {
    await firebase.initializeApp(config);
    Firebase.auth = firebase.auth();
    firebase.auth().onAuthStateChanged(async function(user) {
      if (user !== null) {
        stickHeader = axios.interceptors.request.use(async config => {
          const currentToken = await user.getIdToken();
          config.headers = {...config.headers, Authorization: currentToken};
          return config;
        });
      } else {
        axios.interceptors.request.eject(stickHeader);
      }

      let userData: UserData = null;
      if (user !== null) {
        userData = {...user, photoUrl: user.photoURL};
      }

      store.dispatch(updateUserData(userData));
      store.dispatch(updateLoadingStatus(false));
      const isAdmin = user ? (await user.getIdTokenResult()).claims.isAdmin : false;
      store.dispatch(updateAdminStatus(isAdmin ? isAdmin : false));
    });
  }

  public static signIn = async (email, password) => {
    Firebase.auth.signInWithEmailAndPassword(email, password).catch(error => {
      store.dispatch(updateLastLoginFailureMessage(error.message));
    });
  };

  public static signOut = async () => {
    await Firebase.auth.signOut();
    store.dispatch(updateUserData(null));
  };
}
