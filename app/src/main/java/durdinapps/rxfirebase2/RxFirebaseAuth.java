package durdinapps.rxfirebase2;

import android.support.annotation.NonNull;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

public class RxFirebaseAuth {

   /**
    * Asynchronously signs in as an anonymous user.
    * If there is already an anonymous user signed in, that user will be returned; otherwise, a new anonymous user identity will be created and returned.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @return a {@link Maybe} which emits an {@link AuthResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<AuthResult> signInAnonymously(@NonNull final FirebaseAuth firebaseAuth) {
      return Maybe.create(new MaybeOnSubscribe<AuthResult>() {
         @Override
         public void subscribe(MaybeEmitter<AuthResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.signInAnonymously());
         }
      });
   }

   /**
    * Asynchronously signs in using an email and password.
    * Fails with an error if the email address and password do not match.
    * <p>
    * Note: The user's password is NOT the password used to access the user's email account.
    * The email address serves as a unique identifier for the user, and the password is used to access the user's account in your Firebase project.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param email        email to login.
    * @param password     password to login.
    * @return a {@link Maybe} which emits an {@link AuthResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<AuthResult> signInWithEmailAndPassword(@NonNull final FirebaseAuth firebaseAuth,
                                                              @NonNull final String email,
                                                              @NonNull final String password) {
      return Maybe.create(new MaybeOnSubscribe<AuthResult>() {
         @Override public void subscribe(MaybeEmitter<AuthResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.signInWithEmailAndPassword(email, password));
         }
      });
   }

   /**
    * Asynchronously signs in with the given credentials.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param credential   The auth credential. Value must not be null.
    * @return a {@link Maybe} which emits an {@link AuthResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<AuthResult> signInWithCredential(@NonNull final FirebaseAuth firebaseAuth,
                                                        @NonNull final AuthCredential credential) {
      return Maybe.create(new MaybeOnSubscribe<AuthResult>() {
         @Override
         public void subscribe(MaybeEmitter<AuthResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.signInWithCredential(credential));
         }
      });
   }

   /**
    * Asynchronously signs in using a custom token.
    * <p>
    * Custom tokens are used to integrate Firebase Auth with existing auth systems, and must be generated by the auth backend.
    * <p>
    * Fails with an error if the token is invalid, expired, or not accepted by the Firebase Auth service.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param token        The custom token to sign in with.
    * @return a {@link Maybe} which emits an {@link AuthResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<AuthResult> signInWithCustomToken(@NonNull final FirebaseAuth firebaseAuth,
                                                         @NonNull final String token) {
      return Maybe.create(new MaybeOnSubscribe<AuthResult>() {
         @Override
         public void subscribe(MaybeEmitter<AuthResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.signInWithCustomToken(token));
         }
      });
   }

   /**
    * Creates a new user account associated with the specified email address and password.
    * <p>
    * On successful creation of the user account, this user will also be signed in to your application.
    * <p>
    * User account creation can fail if the account already exists or the password is invalid.
    * <p>
    * Note: The email address acts as a unique identifier for the user and enables an email-based password reset.
    * This function will create a new user account and set the initial user password.
    * <p>
    * Custom tokens are used to integrate Firebase Auth with existing auth systems, and must be generated by the auth backend.
    * <p>
    * Fails with an error if the token is invalid, expired, or not accepted by the Firebase Auth service.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param email        The user's email address.
    * @param password     The user's chosen password.
    * @return a {@link Maybe} which emits an {@link AuthResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<AuthResult> createUserWithEmailAndPassword(@NonNull final FirebaseAuth firebaseAuth,
                                                                  @NonNull final String email,
                                                                  @NonNull final String password) {
      return Maybe.create(new MaybeOnSubscribe<AuthResult>() {
         @Override
         public void subscribe(MaybeEmitter<AuthResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.createUserWithEmailAndPassword(email, password));
         }
      });
   }

   /**
    * Gets the list of provider IDs that can be used to sign in for the given email address. Useful for an "identifier-first" sign-in flow.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param email        An email address.
    * @return a {@link Maybe} which emits an {@link ProviderQueryResult} if success.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Maybe<ProviderQueryResult> fetchProvidersForEmail(@NonNull final FirebaseAuth firebaseAuth,
                                                                   @NonNull final String email) {
      return Maybe.create(new MaybeOnSubscribe<ProviderQueryResult>() {
         @Override
         public void subscribe(MaybeEmitter<ProviderQueryResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, firebaseAuth.fetchProvidersForEmail(email));
         }
      });
   }

   /**
    * Sends a password reset email to the given email address.
    * <p>
    * To complete the password reset, call {@link FirebaseAuth#confirmPasswordReset(String, String)} with the code supplied in
    * the email sent to the user, along with the new password specified by the user.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @param email        The email address with the password to be reset.
    * @return a {@link Completable} which emits when the action is completed.
    * @see <a href="https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth">Firebase Auth API</a>
    */
   @NonNull
   public static Completable sendPasswordResetEmail(@NonNull final FirebaseAuth firebaseAuth,
                                                    @NonNull final String email) {
      return Completable.create(new CompletableOnSubscribe() {
         @Override
         public void subscribe(CompletableEmitter emitter) throws Exception {
            RxCompletableHandler.assignOnTask(emitter, firebaseAuth.sendPasswordResetEmail(email));
         }
      });
   }

   /**
    * Observable which track the auth changes of {@link FirebaseAuth} to listen when an user is logged or not.
    *
    * @param firebaseAuth firebaseAuth instance.
    * @return an {@link Observable} which emits every time that the {@link FirebaseAuth} state change.
    */
   @NonNull
   public static Observable<FirebaseAuth> observeAuthState(@NonNull final FirebaseAuth firebaseAuth) {

      return Observable.create(new ObservableOnSubscribe<FirebaseAuth>() {
         @Override
         public void subscribe(final ObservableEmitter<FirebaseAuth> emitter) throws Exception {
            final FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
               @Override
               public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                  emitter.onNext(firebaseAuth);
               }
            };
            firebaseAuth.addAuthStateListener(authStateListener);
            emitter.setCancellable(new Cancellable() {
               @Override
               public void cancel() throws Exception {
                  firebaseAuth.removeAuthStateListener(authStateListener);
               }
            });
         }
      });
   }
}