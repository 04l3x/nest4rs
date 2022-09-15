use jni::JNIEnv;

use jni::objects::JClass;

#[no_mangle]
#[allow(non_snake_case)]
pub extern "system" fn Java_extern_java_Bindings_hello(env: JNIEnv, class: JClass) {
    let result = env.call_static_method(class, "hi", "()V", &[]).unwrap();

    println!("{:#?}", result);
}

