# kotlin-app

## 뷰 결합 view binding

findViewById() -> 단점 잘못된 id 입력시 null 반환  
Kotlin Android Extensions -> 1.4.20 이후로 폐기됨  
장점 null 안정, 유형 안정  

view binding 의 사용방법
```kotlin
android {
        ...
        viewBinding {
            enabled = true
        }
    }
```
build.gradle(모듈) 에 추가

```kotlin
    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root // View binding
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.btnNext.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }    
```
layout의 fragment_main.xml 을 FragmentMainBinding  
id인 btn_next를 binding.btnNext  

참고  https://developer.android.com/topic/libraries/view-binding?hl=ko  


## navgation

```kotlin
class [Question]Fragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_next -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }
}
```

하나의 main_activity를 두고 여러개의 fragment를 둬서   
효율적인 스크린 이동을 가능하게하는 컴포넌트
