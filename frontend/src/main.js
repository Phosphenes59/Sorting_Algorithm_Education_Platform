import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config';
import 'primevue/resources/themes/aura-light-green/theme.css'
import { createPinia } from 'pinia'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import mainContainer from "@/components/container/container";
import * as ElIconModules from '@element-plus/icons'

const debounce = (fn, delay) => {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
    constructor(callback) {
        callback = debounce(callback, 16);
        super(callback);
    }
}

const app = createApp(App);
const pinia = createPinia();

app.use(router);
app.use(ElementPlus).component('mainContainer',mainContainer);
app.use(PrimeVue);
app.use(pinia);
app.mount('#app');
for(let iconName in ElIconModules){
    app.component(iconName,ElIconModules[iconName])
}

