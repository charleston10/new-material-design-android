# DogHero - Android

The project follows the entire line of Google's standard development, based on Jetpack.

This application only aims to show a list of items so that the user can see some data.

And it also handles error handling if there is any failure to process the request made by the API.

[DOWNLOAD](https://github.com/charleston10/dog-hero-android/blob/master/apk/app-dev-debug.apk) || [VIDEO](https://github.com/charleston10/dog-hero-android/blob/master/assets/video/device-2018-12-20-123845.mp4?raw=true)

<table>
  <thead>
    <tr>
      <th>BASE</th>
      <th>Architecture</th>
      <th>IU</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>AppCompact</td>
      <td>DataBinding</td>
      <td>Navigation</td>
    </tr>
    <tr>
      <td>Android KTX</td>
      <td>Lifecycles</td>
      <td>Material Components</td>
    </tr>
     <tr>
      <td>Kotlin</td>
      <td>LiveData</td>
    </tr>
     <tr>
      <td>Android Arch</td>
      <td>ViewModel</td>
    </tr>
  </tbody>
</table>


**Screens**
<table>
  <th>GIF</th>
  <th>List</th>
  <th>Error APIt</th>
<tr>
  <td>
    <img src="https://github.com/charleston10/dog-hero-android/blob/master/assets/screens/app.gif?raw=true" height="500" width="900"/>
  </td>
<td>
   <img src="https://github.com/charleston10/dog-hero-android/blob/master/assets/screens/list.png?raw=true"/>
  </td>
<td>
   <img src="https://github.com/charleston10/dog-hero-android/blob/master/assets/screens/error.png?raw=true"/>
  </td>
</tr>
</table>
<table>
  <th>Navigation</th>
  <th>Profiler</th>
<tr>
  <td>
   <img src="https://github.com/charleston10/dog-hero-android/blob/master/assets/screens/navigation.png?raw=true"/>
  </td>
<td>
   <img src="https://github.com/charleston10/dog-hero-android/blob/master/assets/screens/profiler.PNG?raw=true"/>
  </td>
</tr>
</table>

## Code
- AAC Android Architecture Components 

*using guide Google JetPack*

- Clean Architecture

*for apply DRY, KISS, SOLID*

- DataBinding 

*bind data model with view*

- ViewModel

 *for interact view with business rules*
 
 - RX

 *for manipulate data and events in different layers of application*
 
 ## LIBRARIES
 
 - Retrofit
 - Dagger Android
 - Material Component
 - Timber
 - Lottie
 - RX Java / RX Android
 

 ## API

 `GET  https://raw.githubusercontent.com/charleston10/dog-hero-android/master/api/myheroes.txt`

 RESPONSE 200 ```{
  "recents": [
    {
      "is_superhero": true,
      "user": {
        "first_name": "Eduardo",
        "image_url": "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1433381/sq135_DH_24012018123600937_98895.png"
      },
      "address_neighborhood": "Parque Chacabuco",
      "price": 55
    },
    {
      "id": 53012,
      "is_superhero": false,
      "user": {
        "first_name": "Maria",
        "image_url": "https://doghero-uploads.s3.amazonaws.com/uploads/photo/764186/sq135_20170404094603_345722_1491353162913.jpg"
      },
      "address_neighborhood": "Aclimacao",
      "price": 60
    }
  ],
  "favorites": [
    {
      "is_superhero": false,
      "user": {
        "first_name": "Cris",
        "image_url": "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1088842/sq135_20170926010555_270986_1506441955458.jpg"
      },
      "address_neighborhood": "Vila Gomes Cardim",
      "price": 70
    },
    {
      "is_superhero": false,
      "user": {
        "first_name": "Gustavo",
        "image_url": "https://doghero-uploads.s3.amazonaws.com/uploads/photo/242781/sq135_Cris_SA-MI.jpg"
      },
      "address_neighborhood": "Vila Mariana",
      "price": 45
    },
    {
      "is_superhero": true,
      "user": {
        "first_name": "Marina",
        "image_url": "https://doghero-uploads.s3.amazonaws.com/uploads/photo/1398933/sq135_1516145372035_517808_IMG0535JPG.jpeg"
      },
      "address_neighborhood": "Vila Mariana",
      "price": 65
    }
  ]
}```

## Design

**Material Components**

https://github.com/material-components

- BottomAppBar
- Toolbar
- RefreshLayout
- RecyclerView
- FloatingButton
- MaterialButton

**Lottie**

http://airbnb.io/lottie/
