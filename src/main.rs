mod lib;


use jni::{InitArgsBuilder, JNIVersion, JavaVM}; //{GlobalRef, JClass, JObject, JString};

fn main() {
    let jvm_args = InitArgsBuilder::new()
        .version(JNIVersion::V8)
        .option("-Xcheck:jni")
        .build()
        .unwrap();

    let jvm = JavaVM::new(jvm_args).unwrap();
    let _guard = jvm.attach_current_thread().unwrap();

    let env = jvm.get_env().unwrap();

    let class = env
        .find_class("extern/java/Bindings")
        .expect("Error on class");


    lib::Java_extern_java_Bindings_hello(env, class);
}
