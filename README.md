# AndroidLiveDataWithDagger2
Android app to fetch movie details for a given query

## Set up api key
<a href="https://www.themoviedb.org/documentation/api">please create an api-key on clicking this link and add it to MovieApiService class to run the project.</a>

Please refer to the following posts describing the code in details:
1. <a href="https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-1-604f50cda1">Getting started with android app architecture components like LiveData and viewmodel</a>
2. <a href="https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-2-di-1a6b1f96d84b">Getting started with android app architecture components with dagger2</a>

The app demonstrates the usage of MVVM architecture pattern using android architecture component library and LiveData and Repository pattern, inspired from Google recommended architecture pattern from I/O 17 .

![](https://cdn-images-1.medium.com/max/960/1*KnYBBZIDDeg4zVDDEcLw2A.png)

**ViewModel** provides the data for a specific UI component, such as a fragment or activity, and handles the communication with the business part of data handling, such as calling other components to load the data or forwarding user modifications. The ViewModel does not know about the View and is not affected by configuration changes such as recreating an activity due to rotation.

**LiveData** is an observable data holder. It lets the components in your app observe LiveData objects for changes without creating explicit and rigid dependency paths between them. LiveData also respects the lifecycle state of your app components (activities, fragments, services) and does the right thing to prevent object leaking so that your app does not consume more memory.

**Repository** modules are responsible for handling data operations. They provide a clean API to the rest of the app. They know where to get the data from and what API calls to make when data is updated.

## Libraries Used
1. <a href="https://developer.android.com/topic/libraries/architecture/adding-components.html">Android Architecture components</a> 
2. <a href="https://google.github.io/dagger/">Dagger2</a> 
3. <a href="http://square.github.io/retrofit/">Retrofit2</a> 
4. <a href="http://jakewharton.github.io/butterknife/">Butterknife</a> 
