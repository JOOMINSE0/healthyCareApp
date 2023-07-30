package com.example.healthycareapp

import android.content.Intent.getIntent
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
class MapsFragment(search: Search) : Fragment(), OnMapReadyCallback {

    lateinit var locationPermission: ActivityResultLauncher<Array<String>>

    private lateinit var mMap: GoogleMap

    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    companion object {
        fun newInstance(): MapsFragment {
            return MapsFragment()
        }

        private fun MapsFragment(): MapsFragment {
            val mapsFragment = MapsFragment.newInstance()
            return mapsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        locationPermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { results ->
            if (!results.all { it.value }) {
                Toast.makeText(activity, "권한 승인이 필요합니다.", Toast.LENGTH_LONG).show()
            }
        }
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        //camera 및 marker 설정
        mMap.apply {
            mMap.clear()
            val seoul = LatLng(37.566418, 126.977943)

            val markerOptions = MarkerOptions()
                .position(seoul)
                .title("Seoul")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions)

            val cameraPosition = CameraPosition.Builder()
                .target(seoul)
                .zoom(15.0f)
                .build()
            val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
            mMap.moveCamera(cameraUpdate)

        }

    }
    private fun Marker?.icon(defaultMarker: BitmapDescriptor) {

    }
}