import { Routes, Route } from "react-router-dom";
import { DocumentTemplateFolderPage } from "./documentTemplate/E_ApprovalTemplateFolder";
import DocumentTemplateRegist from "./documentTemplate/E_ApprovalTemplateRegist";
import { ViewDocument } from "./document/ViewDocument";
import { DraftDocument } from "./document/DraftDocument";
import { DocumentList } from "./document/DocumentList";
import { TemplateView } from "./documentTemplate/TemplateView";

function E_ApprovalRoute() {
    return (
        <Routes>
            <Route path="approval-documents/:type"
                element={<DocumentList />} />

            <Route path="approval-document/:documentId"
                element={<ViewDocument />} />

            <Route path="document-template/folder"
                element={<DocumentTemplateFolderPage
                />}
            ></Route>
            <Route path="document-template/:documentId"
                element={<TemplateView/>}>
                </Route>


            <Route path="document-template/regist"
                element={<DocumentTemplateRegist />}
            ></Route>

            <Route path="draft"
                element={<DraftDocument />}
            ></Route>
        </Routes>
    );
}

export default E_ApprovalRoute;