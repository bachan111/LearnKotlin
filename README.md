# LearnKotlin
kotlin学习项目

需要总结的知识点：
 - FlowCollector
 - flow



资源文件相关{
资源相关文件属于项目相关的，因此需要放在Common组件内，不要放在Base组件里
String、Color、Style、layout、drawable、mipmap 公用的 放在Common组件内，不公用的放在各自组件内，命名以各组件的规则命名(build文件设置了规则)
}


协程相关{
Activity/Fragment 中 可以使用 lifecycleScope,与Activity/Fragment绑定了生命周期 无需手动取消
ViewModel 中 可以使用 viewModelScope,它与ViewModel绑定了生命周期 无需手动取消
lifecycleScope和viewModelScope 默认的调度器是Main
}
