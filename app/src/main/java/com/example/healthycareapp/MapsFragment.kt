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
            val hosp1 = LatLng(37.5672138, 127.0056710 )
            val hosp2 = LatLng( 37.5651100126, 126.9888709)
            val hosp3 = LatLng(37.5555057, 126.9737678)
            val hosp4 = LatLng(37.5664918,126.9818658)
            val hosp5 = LatLng(37.5608909,126.9811087)

            val markerOptions1 = MarkerOptions()
                .position(hosp1)
                .title("국립중앙의료원")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions1)

            val markerOptions2 = MarkerOptions()
                .position(hosp2)
                .title("인제대학교 서울백병원")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions2)

            val markerOptions3 = MarkerOptions()
                .position(hosp3)
                .title("성광의료재단 차여성의원")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions3)

            val markerOptions4 = MarkerOptions()
                .position(hosp4)
                .title("하나은행부속의원")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions4)

            val markerOptions5 = MarkerOptions()
                .position(hosp5)
                .title("김경희건강한마음의원")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            mMap?.addMarker(markerOptions5)

            val cameraPosition = CameraPosition.Builder()
                .target(seoul)
                .zoom(13.0f)
                .build()
            val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
            mMap.moveCamera(cameraUpdate)

        }

    }
    private fun Marker?.icon(defaultMarker: BitmapDescriptor) {

    }
}