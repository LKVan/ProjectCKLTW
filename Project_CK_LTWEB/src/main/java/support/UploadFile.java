package support;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile {

	public static void UploadFileSingle(HttpServletRequest request) {
		String address = "F:\\";

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 10);
		factory.setRepository(new java.io.File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 50);

		try {
			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String name = item.getName();
					System.out.println(name);
					String pathFile = address + File.separator + name;

					File uploadFile = new File(pathFile);
					boolean check = uploadFile.exists();
					
					try {
						if(!check) {
							item.write(uploadFile);
						}
						else {
							request.setAttribute("fileError", "Da ton tai");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
