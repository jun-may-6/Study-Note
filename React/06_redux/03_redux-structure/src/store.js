import {applyMiddleware, legacy_createStore} from 'redux';
import rootReducer from './modules'
import {thunk} from 'redux-thunk';
import logger from 'redux-logger';
import {composeWithDevTools} from "@redux-devtools/extension"

const store = legacy_createStore(
    rootReducer,
    composeWithDevTools(applyMiddleware(thunk, logger))
);

export default store;