package com.example.beautycare;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

public class IAFragment extends Fragment {

    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private PreviewView previewView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_i_a, container, false);
        previewView = view.findViewById(R.id.preview_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, requireContext().getMainExecutor());
    }

    private void bindPreview(ProcessCameraProvider cameraProvider) {
        androidx.camera.core.Preview preview = new androidx.camera.core.Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());
        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_FRONT)
                .build();
        cameraProvider.bindToLifecycle(getViewLifecycleOwner(), cameraSelector, preview);
    }
}

