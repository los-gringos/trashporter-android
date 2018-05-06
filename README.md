# trashporter-android

## Introduction

> This Android application is based on the needs of the trash service(garbage pick up). It implements an algorithm that focuses on finding the shortest path towards possible markers(villages, cities etc.) on a Google map. This way the driver of the truck wil win valuable time.

## Code Samples

> public void zoomOnMarkers(GoogleMap googleMap) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        LatLngBounds bounds = builder.build();

        int padding = 150; // offset from edges of the map in pixels

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        googleMap.moveCamera(cu);

        googleMap.animateCamera(cu);
    }


----------------------------------------------------------------------------------------------------




## Installation

> The App is still in demo mode so it is note available yet on Google Store. It has to be installed manually by passing the .apk file directly to android folder. 

Here's a topic on how you can do that. --> https://www.wikihow.tech/Install-APK-Files-on-Android
