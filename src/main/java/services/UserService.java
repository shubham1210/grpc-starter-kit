package services;

import com.bain.grpc.User;
import com.bain.grpc.userGrpc;
import io.grpc.stub.StreamObserver;
import com.bain.grpc.User.APIResponse;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login");

        String username = request.getUsername();
        String password = request.getPassword();
        APIResponse.Builder response = APIResponse.newBuilder();

        //this should not be the actual case :P
        if(username.equals(password))
            response.setResponseCode(200).setResponseMessage("Successfully Login");
        else {
            response.setResponseCode(401).setResponseMessage("Invalid Credential");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Logout");

        APIResponse.Builder response = APIResponse.newBuilder();

        //this should not be the actual case :P
        response.setResponseCode(200).setResponseMessage("Successfully Logout");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
