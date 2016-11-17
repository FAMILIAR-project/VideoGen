/**
 */
package playlist.tests;

import junit.textui.TestRunner;

import playlist.Comment;
import playlist.PlaylistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommentTest extends EntryTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CommentTest.class);
	}

	/**
	 * Constructs a new Comment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Comment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Comment getFixture() {
		return (Comment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createComment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //CommentTest
