 <template>
   <a-row class="login">
     <a-col :span="8" :offset="8" class="login-main">
       <h1 style="text-align: center"><rocket-two-tone/>&nbsp;轨道贾克斯Track-Tix售票系统</h1>
       <a-form
           :model="loginForm"
           name="basic"
           autocomplete="off"
       >
         <a-form-item
             label=""
             name="mobile"
             :rules="[{ required: true, message: 'Please input your username!' }]"
         >
           <a-input v-model:value="loginForm.mobile" />
         </a-form-item>

         <a-form-item
             label=""
             name="code"
             :rules="[{ required: true, message: 'Please input your password!' }]"
         >
           <a-input v-model:value="loginForm.code">
             <template #addonAfter>
               <a @click="sendCode">获取验证码</a>
             </template>
           </a-input>
         </a-form-item>

         <a-form-item>
           <a-button type="primary" block @click="login">登录</a-button>
         </a-form-item>
       </a-form>
     </a-col>
   </a-row>

</template>

 <script setup>
 import { reactive } from 'vue';
 import axios from 'axios';
 import {notification} from 'ant-design-vue';
 import {useRouter} from 'vue-router';
 import { useMemberStore } from '@/store/index.js'

 const loginForm = reactive({
   mobile: '17389889467',
   code: '请输入验证码',
 });
 const router = useRouter();

 const sendCode = () => {
   axios.post("/member/member/send-code",{
     mobile: loginForm.mobile
   }).then(response => {
     let data = response.data;
     if (data.success){
       notification.success({description:'发送验证码成功'});
       loginForm.code = "8888";
     }else{
       notification.error({description:data.message});
     }
   });
 };

 const login = () => {
   axios.post("/member/member/login",loginForm).then(response => {
     let data = response.data;
     if (data.success){
       notification.success({description:'登录成功'});
       // 登录成功，跳转到控台主页
       router.push("/main");
       const store = useMemberStore();
       store.setMember(data.content);
     }else{
       notification.error({description:data.message});
     }
   });
 };
 </script>

 <style>
 .login-main h1 {
   font-size: 25px;
   font-weight: bold;
 }
 .login-main {
   margin-top: 100px;
   padding: 30px 80px 20px 80px;
   border: 2px solid grey;
   border-radius: 10px;
   background-color: #fcfcfc;
 }
 </style>
