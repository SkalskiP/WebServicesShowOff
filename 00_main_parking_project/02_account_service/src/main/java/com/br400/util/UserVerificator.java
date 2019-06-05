package com.br400.util;

import com.br400.JSON.VerificationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

public class UserVerificator {
    public static VerificationResult verifyUser(String idToken) {
        try {
            FirebaseToken token = FirebaseAuth.getInstance().verifyIdToken(idToken);
            UserRecord user = FirebaseAuth.getInstance().getUser(token.getUid());
            Boolean isAdmin = (Boolean) user.getCustomClaims().getOrDefault("isAdmin", false);
            return new VerificationResult(true, isAdmin, token.getUid());
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return new VerificationResult(false, false, null);
        }
    }
}
