import * as firebase from "firebase";
import {store} from "../index";
import {updateUserData} from "../store/account/actionCreators";
import axios from 'axios';

const config = {
  apiKey: "AIzaSyBUk6dgMPAs7zM46FGg3ICj_0lU1sfjc88",
  authDomain: "webservicesshowoff.firebaseapp.com",
  databaseURL: "https://webservicesshowoff.firebaseio.com",
  projectId: "webservicesshowoff",
  storageBucket: "webservicesshowoff.appspot.com",
  messagingSenderId: "977543366915",
  appId: "1:977543366915:web:3d964a1c474d145c"
};

let stickHeader = null;

export class Firebase {
  public static auth;

  public static async setup() {
    await firebase.initializeApp(config);
    Firebase.auth = firebase.auth();
    firebase.auth().onAuthStateChanged(function(user) {
      store.dispatch(updateUserData(user));
    });
  }

  public static signIn = async (email, password) => {
    const result = await Firebase.auth.signInWithEmailAndPassword(
      email,
      password
    );
    stickHeader = axios.interceptors.request.use((config) => {
      config.headers = {...config.headers, Authorization: result.user.getIdToken()};
      return config;
    });
    store.dispatch(updateUserData(result.user));
  };

  public static signOut = async () => {
    await Firebase.auth.signOut();
    axios.interceptors.request.eject(stickHeader);
    store.dispatch(updateUserData(null));
  };
}
