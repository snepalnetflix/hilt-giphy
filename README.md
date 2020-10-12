# Hilt Giphy  
  
This project demonstrates how to build an Android app using dependency inversion. Each feature of the app is decoupled from other features. The final app is assembled by declaring dependencies on all necessary features.  
  
Dependencies between features are bound using Hilt.  
  
# Features  
  
All features have 3 gradle modules:  
* feature/api  
* feature/impl  
* feature/module  
  
## API  
  
The API module is mostly interfaces. Users of the feature inject instances of the feature to invoke the API. For example, given the following API  
```  
interface Feature {  
  fun performAction()  
}  
```  
  
Then the caller would invoke the API like this:  
```  
@AndroidEntryPoint(Fragment::class)  
class MyFragment : Hilt_MyFragment {  
  @Inject  
  lateinit var feature: Feature  
  ...  
  fun onClick() {  
    feature.performAction()  
  }  
}  
```  
  
An important rule is that feature users can declare dependencies on feature/api but never on feature/impl or feature/module. (TODO(sail): Add lint rule to enforce this.)  
  
## Impl  
  
The implementation module implements all the APIs. For example:  
```  
class FeatureImpl @Inject constructor() : Feature {  
  override fun performAction() {  
  }  
}  
```  
  
The key rule of this architecture is that impl gradle module is only pulled in as a dependency inside feature/module/build.gradle.  
  
## Module  
  
This gradle module declares bindings between the API and implementation. For example:  
```  
@Module  
@InstallIn(SingletonComponent::class)  
interface FeatureModule {  
  @Binds  
  fun bindFeature(impl: FeatureImpl): Feature  
}  
```  
  
The module dependency is pulled into "root" modules. For example, the application gradle module and tests.  
  
# App assembly  
  
A key principle of this project is that the app gradle module is lightweight. The code inside the app module has no knowledge of any features. This allows all features to be configured via dependencies. The only code in the app is the declaration of the dagger root:  
```  
@HiltAndroidApp(Application::class)  
Class MyApplication : Hilt_MyApplicaton  
```  
  
# Optional Features  
  
TODO(sail) Add example of optional feature.

# Testing

TODO(sail) Add examples of testing.
